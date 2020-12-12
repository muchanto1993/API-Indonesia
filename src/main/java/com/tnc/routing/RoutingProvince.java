package com.tnc.routing;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tnc.model.ModelCity;
import com.tnc.model.ModelProvince;
import com.tnc.model.ModelSubDistrict;
import com.tnc.model.ModelUrban;
import com.tnc.service.ServiceProvince;
import com.tnc.util.ResponseFormat;
import com.tnc.util.ResponseMessageFormat;

import org.springframework.http.HttpStatus;

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
        List<ModelProvince> listData = serviceProvince.findAllProvince();
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

    public ResponseFormat allSubDistrict(HttpServletRequest request, ServiceProvince serviceProvince) {
        /* Informasi Tentang Nama Method */
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

        /* Memanggil Class Response yang telah dibuat */
        ResponseFormat responseFormat = new ResponseFormat();
        responseFormat.setTimestamp(new Date());
        responseFormat.setStatus(HttpStatus.OK.value());
        responseFormat.setError("");
        responseFormat.setPath(request.getRequestURI() + " | " + nameofCurrMethod);

        /* Set Data Dari Database */
        List<ModelSubDistrict> listData = serviceProvince.findAllSubDistrict();
        int lenghData = listData.size();

        ResponseMessageFormat responseMessageFormat = new ResponseMessageFormat();
        responseMessageFormat.setLength_data(lenghData);
        responseMessageFormat.setData(listData);

        responseFormat.setMessage(responseMessageFormat);

        return responseFormat;
    }

    public ResponseFormat specificSubDistrictByCity(HttpServletRequest request, ServiceProvince serviceProvince,
            String city) {
        /* Informasi Tentang Nama Method */
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

        /* Memanggil Class Response yang telah dibuat */
        ResponseFormat responseFormat = new ResponseFormat();
        responseFormat.setTimestamp(new Date());
        responseFormat.setStatus(HttpStatus.OK.value());
        responseFormat.setError("");
        responseFormat.setPath(request.getRequestURI() + " | " + nameofCurrMethod);

        /* Set Data Dari Database */
        List<ModelSubDistrict> listData = serviceProvince.findSpecificSubDistrictByCity(city);
        int lenghData = listData.size();

        ResponseMessageFormat responseMessageFormat = new ResponseMessageFormat();
        responseMessageFormat.setLength_data(lenghData);
        responseMessageFormat.setData(listData);

        responseFormat.setMessage(responseMessageFormat);

        return responseFormat;
    }

    public ResponseFormat allUrban(HttpServletRequest request, ServiceProvince serviceProvince) {
        /* Informasi Tentang Nama Method */
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

        /* Memanggil Class Response yang telah dibuat */
        ResponseFormat responseFormat = new ResponseFormat();
        responseFormat.setTimestamp(new Date());
        responseFormat.setStatus(HttpStatus.OK.value());
        responseFormat.setError("");
        responseFormat.setPath(request.getRequestURI() + " | " + nameofCurrMethod);

        /* Set Data Dari Database */
        List<ModelUrban> listData = serviceProvince.findAllUrban();
        int lenghData = listData.size();

        ResponseMessageFormat responseMessageFormat = new ResponseMessageFormat();
        responseMessageFormat.setLength_data(lenghData);
        responseMessageFormat.setData(listData);

        responseFormat.setMessage(responseMessageFormat);

        return responseFormat;
    }

    public ResponseFormat specificUrbanBySubDistrict(HttpServletRequest request, ServiceProvince serviceProvince,
            String subDistrict) {
        /* Informasi Tentang Nama Method */
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

        /* Memanggil Class Response yang telah dibuat */
        ResponseFormat responseFormat = new ResponseFormat();
        responseFormat.setTimestamp(new Date());
        responseFormat.setStatus(HttpStatus.OK.value());
        responseFormat.setError("");
        responseFormat.setPath(request.getRequestURI() + " | " + nameofCurrMethod);

        /* Set Data Dari Database */
        List<ModelUrban> listData = serviceProvince.findSpecificUrbanBySubDistrict(subDistrict);
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
