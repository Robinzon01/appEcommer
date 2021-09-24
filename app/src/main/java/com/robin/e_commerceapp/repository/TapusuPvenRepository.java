package com.robin.e_commerceapp.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.robin.e_commerceapp.api.ConfigApi;
import com.robin.e_commerceapp.api.IUsuarioApi;
import com.robin.e_commerceapp.entity.GenericResponse;
import com.robin.e_commerceapp.entity.service.TapusuPven;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TapusuPvenRepository {
    private static TapusuPvenRepository repository;
    private final IUsuarioApi api;

    public TapusuPvenRepository(){
        this.api = ConfigApi.getUsuarioApi();
    }

    public static TapusuPvenRepository getInstance(){
        if ( repository == null){
            repository = new TapusuPvenRepository();
        }
        return repository;
    }

    public LiveData<GenericResponse<TapusuPven>> login(TapusuPven tapusuPven){
        final MutableLiveData<GenericResponse<TapusuPven>> mld = new MutableLiveData<>();
        this.api.login(tapusuPven).enqueue(new Callback<GenericResponse<TapusuPven>>() {
            @Override
            public void onResponse(Call<GenericResponse<TapusuPven>> call, Response<GenericResponse<TapusuPven>> response) {
                mld.setValue(response.body());
            }

            @Override
            public void onFailure(Call<GenericResponse<TapusuPven>> call, Throwable t) {
                mld.setValue(new GenericResponse());
                System.out.println("Se ha producido un error al iniciar sessión: "+t.getMessage());
                t.printStackTrace();
            }
        });
        return mld;
    }

}
