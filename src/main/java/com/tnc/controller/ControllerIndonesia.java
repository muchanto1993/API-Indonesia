package com.tnc.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.tnc.routing.RoutingProvince;
import com.tnc.service.ServiceProvince;
import com.tnc.util.RequestBodyFormat;
import com.tnc.util.RequestDataFormat;
import com.tnc.util.ResponseFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerIndonesia {

        @Autowired
        private ServiceProvince serviceProvince;

        @PostMapping("/apiindonesia")
        public ResponseEntity<ResponseFormat> apiIndonesia(HttpServletRequest request,
                        @RequestBody RequestBodyFormat requestBodyFormat) {
                return RoutingFunction(request, requestBodyFormat);
        }

        public ResponseEntity<ResponseFormat> RoutingFunction(HttpServletRequest request,
                        RequestBodyFormat requestBodyFormat) {
                int function_code = requestBodyFormat.getFunction_code();
                RequestDataFormat requestDataFormat = requestBodyFormat.getData();

                RoutingProvince routingProvince = new RoutingProvince();
                ResponseFormat responseFormat = new ResponseFormat();
                ResponseEntity<ResponseFormat> responseEntity = null;

                switch (function_code) {
                        case 101:
                                responseFormat = routingProvince.allProvince(request, serviceProvince);
                                responseEntity = ResponseEntity.status(HttpStatus.OK)
                                                .contentType(MediaType.APPLICATION_JSON).body(responseFormat);
                                break;

                        case 102:
                                responseFormat = routingProvince.specificProvinceName(request, serviceProvince,
                                                requestDataFormat.getProvince_name());
                                responseEntity = ResponseEntity.status(HttpStatus.OK)
                                                .contentType(MediaType.APPLICATION_JSON).body(responseFormat);
                                break;

                        case 201:
                                responseFormat = routingProvince.allCity(request, serviceProvince);
                                responseEntity = ResponseEntity.status(HttpStatus.OK)
                                                .contentType(MediaType.APPLICATION_JSON).body(responseFormat);
                                break;

                        case 202:
                                responseFormat = routingProvince.specificCityByProvinceName(request, serviceProvince,
                                                requestDataFormat.getProvince_name());
                                responseEntity = ResponseEntity.status(HttpStatus.OK)
                                                .contentType(MediaType.APPLICATION_JSON).body(responseFormat);
                                break;

                        case 501:
                                responseFormat = routingProvince.specificPostalCode(request, serviceProvince,
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

                return responseEntity;
        }

}
