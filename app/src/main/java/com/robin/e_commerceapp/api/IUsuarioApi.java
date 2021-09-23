package com.robin.e_commerceapp.api;

import com.robin.e_commerceapp.entity.GenericResponse;
import com.robin.e_commerceapp.entity.service.TapusuPven;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IUsuarioApi {
    String base = "api/usuario";

    @POST(base+"/login")
    Call<GenericResponse<TapusuPven>> login(@Body TapusuPven tapusuPven);
}
