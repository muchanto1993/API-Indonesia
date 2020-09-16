package com.tnc.routing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tnc.entitty.EntityPostalCode;
import com.tnc.model.ModelCity;
import com.tnc.model.ModelPostalCode;
import com.tnc.model.ModelProvince;
import com.tnc.service.ServiceProvince;
import com.tnc.util.ResponseFormat;
import com.tnc.util.ResponseMessageFormat;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;

import springfox.documentation.service.ResponseMessage;

public class RoutingProvince {

    public ResponseFormat allProvince(HttpServletRequest request, ServiceProvince serviceProvince) {
        /* Informasi Tentang Nama Method */
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

        /* Memanggil Class Response yang telah dibuat */
        ResponseFormat responseFormat = new ResponseFormat();
        responseFormat.setTimestamp(new Date());
        responseFormat.setStatus(HttpStatus.OK.value());
        responseFormat.setError("");
        responseFormat.setPath(request.getRequestURI() + " | " + nameofCurrMethod);

        /* Set Data Dari Database */
        List<ModelProvince> listData = serviceProvince.findAll();
        int lenghData = listData.size();

        ResponseMessageFormat responseMessageFormat = new ResponseMessageFormat();
        responseMessageFormat.setLength_data(lenghData);
        responseMessageFormat.setData(listData);

        responseFormat.setMessage(responseMessageFormat);

        return responseFormat;
    }

    public ResponseFormat specificProvinceName(HttpServletRequest request, ServiceProvince serviceProvince,
            String provinceName) {
        /* Informasi Tentang Nama Method */
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

        /* Memanggil Class Response yang telah dibuat */
        ResponseFormat responseFormat = new ResponseFormat();
        responseFormat.setTimestamp(new Date());
        responseFormat.setStatus(HttpStatus.OK.value());
        responseFormat.setError("");
        responseFormat.setPath(request.getRequestURI() + " | " + nameofCurrMethod);

        /* Set Data Dari Database */
        List<ModelProvince> listData = serviceProvince.findSpecificProvinceByProvinceName(provinceName);
        int lenghData = listData.size();

        ResponseMessageFormat responseMessageFormat = new ResponseMessageFormat();
        responseMessageFormat.setLength_data(lenghData);
        responseMessageFormat.setData(listData);

        responseFormat.setMessage(responseMessageFormat);

        return responseFormat;
    }

    public ResponseFormat allCity(HttpServletRequest request, ServiceProvince serviceProvince) {
        /* Informasi Tentang Nama Method */
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

        /* Memanggil Class Response yang telah dibuat */
        ResponseFormat responseFormat = new ResponseFormat();
        responseFormat.setTimestamp(new Date());
        responseFormat.setStatus(HttpStatus.OK.value());
        responseFormat.setError("");
        responseFormat.setPath(request.getRequestURI() + " | " + nameofCurrMethod);

        /* Set Data Dari Database */
        List<ModelCity> listData = serviceProvince.findAllCity();
        int lenghData = listData.size();

        ResponseMessageFormat responseMessageFormat = new ResponseMessageFormat();
        responseMessageFormat.setLength_data(lenghData);
        responseMessageFormat.setData(listData);

        responseFormat.setMessage(responseMessageFormat);

        return responseFormat;
    }

    public ResponseFormat specificCityByProvinceName(HttpServletRequest request, ServiceProvince serviceProvince,
            String provinceName) {
        /* Informasi Tentang Nama Method */
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

        /* Memanggil Class Response yang telah dibuat */
        ResponseFormat responseFormat = new ResponseFormat();
        responseFormat.setTimestamp(new Date());
        responseFormat.setStatus(HttpStatus.OK.value());
        responseFormat.setError("");
        responseFormat.setPath(request.getRequestURI() + " | " + nameofCurrMethod);

        /* Set Data Dari Database */
        List<ModelCity> listData = serviceProvince.findSpecificCityByProvinceName(provinceName);
        int lenghData = listData.size();

        ResponseMessageFormat responseMessageFormat = new ResponseMessageFormat();
        responseMessageFormat.setLength_data(lenghData);
        responseMessageFormat.setData(listData);

        responseFormat.setMessage(responseMessageFormat);

        return responseFormat;
    }

    public ResponseFormat specificPostalCode(HttpServletRequest request, ServiceProvince serviceProvince,
            String postal_code) {
        /* Informasi Tentang Nama Method */
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

        /* Memanggil Class Response yang telah dibuat */
        ResponseFormat responseFormat = new ResponseFormat();
        responseFormat.setTimestamp(new Date());
        responseFormat.setStatus(HttpStatus.OK.value());
        responseFormat.setError("");
        responseFormat.setPath(request.getRequestURI() + " | " + nameofCurrMethod);

        /* Set Data Dari Database */
        ResponseMessageFormat responseMessageFormat = new ResponseMessageFormat();
        responseMessageFormat.setLength_data(serviceProvince.findByPostalCode(postal_code).size());
        responseMessageFormat.setData(serviceProvince.findByPostalCode(postal_code));

        responseFormat.setMessage(responseMessageFormat);

        return responseFormat;
    }

}
