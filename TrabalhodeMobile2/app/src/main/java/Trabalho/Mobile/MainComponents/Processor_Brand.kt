package Trabalho.Mobile.MainComponents


enum class CPU_Brands(val cpuBrand:String){
    AMD("AMD Ryzen"),
    INTEL("Intel Core")
}

abstract class Processor_Brand {

    abstract var amountOfCores : Int
    abstract var frequency : Float
}