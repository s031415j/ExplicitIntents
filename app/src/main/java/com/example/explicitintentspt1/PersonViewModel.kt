package com.example.explicitintentspt1

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class PersonViewModel : ViewModel(){
    var firstName = ObservableField<String>()
        private set
    var surname = ObservableField<String>()
        private set
}