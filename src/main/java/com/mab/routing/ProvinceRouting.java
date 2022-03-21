package com.mab.routing;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mab.format.ResponseFormat;
import com.mab.format.ResponseMessageFormat;
import com.mab.model.CityModel;
import com.mab.model.ProvinceModel;
import com.mab.model.SubDistrictModel;
import com.mab.model.UrbanModel;
import com.mab.service.IndonesiaService;

import org.springframework.http.HttpStatus;

public class ProvinceRouting {

    public ResponseFormat allProvince(HttpServletRequest request, IndonesiaService serviceProvince) {
        /* Informasi Tentang Nama Method */
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

        /* Memanggil Class Response yang telah dibuat */
        ResponseFormat responseFormat = new ResponseFormat();
        responseFormat.setTimestamp(new Date());
        responseFormat.setStatus(HttpStatus.OK.value());
        responseFormat.setError("");
        responseFormat.setPath(request.getRequestURI() + " | " + nameofCurrMethod);

        /* Set Data Dari Database */
        List<ProvinceModel> listData = serviceProvince.findAllProvince();
        int lenghData = listData.size();

        ResponseMessageFormat responseMessageFormat = new ResponseMessageFormat();
        responseMessageFormat.setLength_data(lenghData);
        responseMessageFormat.setData(listData);

        responseFormat.setMessage(responseMessageFormat);

        return responseFormat;
    }

    public ResponseFormat specificProvinceName(HttpServletRequest request, IndonesiaService serviceProvince,
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
        List<ProvinceModel> listData = serviceProvince.findSpecificProvinceByProvinceName(provinceName);
        int lenghData = listData.size();

        ResponseMessageFormat responseMessageFormat = new ResponseMessageFormat();
        responseMessageFormat.setLength_data(lenghData);
        responseMessageFormat.setData(listData);

        responseFormat.setMessage(responseMessageFormat);

        return responseFormat;
    }

    public ResponseFormat allCity(HttpServletRequest request, IndonesiaService serviceProvince) {
        /* Informasi Tentang Nama Method */
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

        /* Memanggil Class Response yang telah dibuat */
        ResponseFormat responseFormat = new ResponseFormat();
        responseFormat.setTimestamp(new Date());
        responseFormat.setStatus(HttpStatus.OK.value());
        responseFormat.setError("");
        responseFormat.setPath(request.getRequestURI() + " | " + nameofCurrMethod);

        /* Set Data Dari Database */
        List<CityModel> listData = serviceProvince.findAllCity();
        int lenghData = listData.size();

        ResponseMessageFormat responseMessageFormat = new ResponseMessageFormat();
        responseMessageFormat.setLength_data(lenghData);
        responseMessageFormat.setData(listData);

        responseFormat.setMessage(responseMessageFormat);

        return responseFormat;
    }

    public ResponseFormat specificCityByProvinceName(HttpServletRequest request, IndonesiaService serviceProvince,
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
        List<CityModel> listData = serviceProvince.findSpecificCityByProvinceName(provinceName);
        int lenghData = listData.size();

        ResponseMessageFormat responseMessageFormat = new ResponseMessageFormat();
        responseMessageFormat.setLength_data(lenghData);
        responseMessageFormat.setData(listData);

        responseFormat.setMessage(responseMessageFormat);

        return responseFormat;
    }

    public ResponseFormat allSubDistrict(HttpServletRequest request, IndonesiaService serviceProvince) {
        /* Informasi Tentang Nama Method */
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

        /* Memanggil Class Response yang telah dibuat */
        ResponseFormat responseFormat = new ResponseFormat();
        responseFormat.setTimestamp(new Date());
        responseFormat.setStatus(HttpStatus.OK.value());
        responseFormat.setError("");
        responseFormat.setPath(request.getRequestURI() + " | " + nameofCurrMethod);

        /* Set Data Dari Database */
        List<SubDistrictModel> listData = serviceProvince.findAllSubDistrict();
        int lenghData = listData.size();

        ResponseMessageFormat responseMessageFormat = new ResponseMessageFormat();
        responseMessageFormat.setLength_data(lenghData);
        responseMessageFormat.setData(listData);

        responseFormat.setMessage(responseMessageFormat);

        return responseFormat;
    }

    public ResponseFormat specificSubDistrictByCity(HttpServletRequest request, IndonesiaService serviceProvince,
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
        List<SubDistrictModel> listData = serviceProvince.findSpecificSubDistrictByCity(city);
        int lenghData = listData.size();

        ResponseMessageFormat responseMessageFormat = new ResponseMessageFormat();
        responseMessageFormat.setLength_data(lenghData);
        responseMessageFormat.setData(listData);

        responseFormat.setMessage(responseMessageFormat);

        return responseFormat;
    }

    public ResponseFormat allUrban(HttpServletRequest request, IndonesiaService serviceProvince) {
        /* Informasi Tentang Nama Method */
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

        /* Memanggil Class Response yang telah dibuat */
        ResponseFormat responseFormat = new ResponseFormat();
        responseFormat.setTimestamp(new Date());
        responseFormat.setStatus(HttpStatus.OK.value());
        responseFormat.setError("");
        responseFormat.setPath(request.getRequestURI() + " | " + nameofCurrMethod);

        /* Set Data Dari Database */
        List<UrbanModel> listData = serviceProvince.findAllUrban();
        int lenghData = listData.size();

        ResponseMessageFormat responseMessageFormat = new ResponseMessageFormat();
        responseMessageFormat.setLength_data(lenghData);
        responseMessageFormat.setData(listData);

        responseFormat.setMessage(responseMessageFormat);

        return responseFormat;
    }

    public ResponseFormat specificUrbanBySubDistrict(HttpServletRequest request, IndonesiaService serviceProvince,
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
        List<UrbanModel> listData = serviceProvince.findSpecificUrbanBySubDistrict(subDistrict);
        int lenghData = listData.size();

        ResponseMessageFormat responseMessageFormat = new ResponseMessageFormat();
        responseMessageFormat.setLength_data(lenghData);
        responseMessageFormat.setData(listData);

        responseFormat.setMessage(responseMessageFormat);

        return responseFormat;
    }

    public ResponseFormat specificPostalCode(HttpServletRequest request, IndonesiaService serviceProvince,
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
