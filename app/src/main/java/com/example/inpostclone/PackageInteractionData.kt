package com.example.inpostclone

data class PackageInteractionData(val action: String){
    val tittle = action
    val topText = "Nie " + action + "jeszcze zadnej przesylki";
    val bottomText = "Kliknij + aby" + action + "przesylke";
}
