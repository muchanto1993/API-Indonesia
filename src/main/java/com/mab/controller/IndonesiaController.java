package com.mab.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mab.format.RequestBodyFormat;
import com.mab.format.RequestDataFormat;
import com.mab.format.ResponseFormat;
import com.mab.routing.ProvinceRouting;
import com.mab.service.IndonesiaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class IndonesiaController {

        // Creating Object of ObjectMapper define in Jakson Api
        private ObjectMapper objectMapper = new ObjectMapper();

        @Autowired
        private IndonesiaService indonesiaService;

        @GetMapping("/")
        public String helloIndonesia() {
                return "Indonesia Service is Running";
        }

        @PostMapping("/apiindonesia")
        public ResponseEntity<ResponseFormat> apiIndonesia(HttpServletRequest request,
                        @RequestBody RequestBodyFormat requestBodyFormat) {
                log.info("Request Client : " + request.getRemoteAddr());

                try {
                        // get Oraganisation object as a json string
                        String jsonString = objectMapper.writeValueAsString(requestBodyFormat);

                        // Displaying JSON String
                        log.info("Request Message : " + jsonString);
                } catch (IOException e) {
                        e.printStackTrace();
                }

                return RoutingFunction(request, requestBodyFormat);
        }

        public ResponseEntity<ResponseFormat> RoutingFunction(HttpServletRequest request,
                        RequestBodyFormat requestBodyFormat) {
                int function_code = requestBodyFormat.getFunction_code();
                RequestDataFormat requestDataFormat = requestBodyFormat.getData();

                ProvinceRouting routingProvince = new ProvinceRouting();
                ResponseFormat responseFormat = new ResponseFormat();
                ResponseEntity<ResponseFormat> responseEntity = null;

                switch (function_code) {
                        case 101:
                                responseFormat = routingProvince.allProvince(request, indonesiaService);
                                responseEntity = ResponseEntity.status(HttpStatus.OK)
                                                .contentType(MediaType.APPLICATION_JSON).body(responseFormat);
                                break;

                        case 102:
                                responseFormat = routingProvince.specificProvinceName(request, indonesiaService,
                                                requestDataFormat.getProvince_name());
                                responseEntity = ResponseEntity.status(HttpStatus.OK)
                                                .contentType(MediaType.APPLICATION_JSON).body(responseFormat);
                                break;

                        case 201:
                                responseFormat = routingProvince.allCity(request, indonesiaService);
                                responseEntity = ResponseEntity.status(HttpStatus.OK)
                                                .contentType(MediaType.APPLICATION_JSON).body(responseFormat);
                                break;

                        case 202:
                                responseFormat = routingProvince.specificCityByProvinceName(request, indonesiaService,
                                                requestDataFormat.getProvince_name());
                                responseEntity = ResponseEntity.status(HttpStatus.OK)
                                                .contentType(MediaType.APPLICATION_JSON).body(responseFormat);
                                break;

                        case 301:
                                responseFormat = routingProvince.allSubDistrict(request, indonesiaService);
                                responseEntity = ResponseEntity.status(HttpStatus.OK)
                                                .contentType(MediaType.APPLICATION_JSON).body(responseFormat);
                                break;

                        case 302:
                                responseFormat = routingProvince.specificSubDistrictByCity(request, indonesiaService,
                                                requestDataFormat.getCity());
                                responseEntity = ResponseEntity.status(HttpStatus.OK)
                                                .contentType(MediaType.APPLICATION_JSON).body(responseFormat);
                                break;

                        case 401:
                                responseFormat = routingProvince.allUrban(request, indonesiaService);
                                responseEntity = ResponseEntity.status(HttpStatus.OK)
                                                .contentType(MediaType.APPLICATION_JSON).body(responseFormat);
                                break;

                        case 402:
                                responseFormat = routingProvince.specificUrbanBySubDistrict(request, indonesiaService,
                                                requestDataFormat.getSub_district());
                                responseEntity = ResponseEntity.status(HttpStatus.OK)
                                                .contentType(MediaType.APPLICATION_JSON).body(responseFormat);
                                break;

                        case 501:
                                responseFormat = routingProvince.specificPostalCode(request, indonesiaService,
                                                requestDataFormat.getPostal_code());
                                responseEntity = ResponseEntity.status(HttpStatus.OK)
                                                .contentType(MediaType.APPLICATION_JSON).body(responseFormat);
                                break;

                        default:
                                /* Informasi Tentang Nama Method */
                                String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

                                /* Memanggil Class Response yang telah dibuat */
                                responseFormat.setTimestamp(new Date());
                                responseFormat.setStatus(HttpStatus.OK.value());
                                responseFormat.setError("");
                                responseFormat.setPath(request.getRequestURI() + " | " + nameofCurrMethod);

                                /* Set Data Dari Database */
                                // responseFormat.setMessage(new String(
                                // "Function Code " + function_code + " Tidak Terdaftar Di System"));

                                responseEntity = ResponseEntity.status(HttpStatus.OK)
                                                .contentType(MediaType.APPLICATION_JSON).body(responseFormat);
                                break;
                }

                try {
                        // get Oraganisation object as a json string
                        String jsonString = objectMapper.writeValueAsString(responseEntity);

                        // Displaying JSON String
                        log.info("Respose Message : " + jsonString);
                } catch (IOException e) {
                        e.printStackTrace();
                }

                return responseEntity;
        }

}
