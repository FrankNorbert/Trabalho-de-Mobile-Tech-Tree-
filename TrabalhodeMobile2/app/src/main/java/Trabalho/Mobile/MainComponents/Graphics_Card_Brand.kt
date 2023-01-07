package Trabalho.Mobile.MainComponents

enum class GPU_Brands(val brandName: String){
    INTEL("Intel Arc"),
    AMD("AMD Radeon"),
    NVIDIA("NVIDIA GeForce")
}

class Graphics_Card_Brand {

    var amountOfCores : Short = 0
    var frequency : Double = 0.0
    var memoryBus : Short = 0
    var memorySize : Byte = 0
    var powerConsumption : Float = 0.0F

    lateinit var gpuBrand : GPU_Brands

    constructor(){

    }


}