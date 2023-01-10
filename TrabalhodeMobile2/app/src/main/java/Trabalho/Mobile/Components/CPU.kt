package Trabalho.Mobile.Components

class CPU {

    enum class CPU_Brands{
        Intel,
        AMD
    }

    var cores : Byte? = null
    var threads : Byte? = null
    var frequency : Float? = null
    var socket : String? = null

}