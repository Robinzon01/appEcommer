package com.robin.e_commerceapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import org.jetbrains.annotations.NotNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.robin.e_commerceapp.entity.GenericResponse;
import com.robin.e_commerceapp.entity.service.TapusuPven;
import com.robin.e_commerceapp.repository.TapusuPvenRepository;
//AndroidViewModel
public class TapusuPvenViewModel extends AndroidViewModel {

    private final TapusuPvenRepository repository;

    public TapusuPvenViewModel(@NonNull @NotNull Application application) {
        super(application);
        this.repository = TapusuPvenRepository.getInstance();
    }
    public LiveData<GenericResponse<TapusuPven>> login(TapusuPven tapusuPven){
        return repository.login(tapusuPven);
    }
}
