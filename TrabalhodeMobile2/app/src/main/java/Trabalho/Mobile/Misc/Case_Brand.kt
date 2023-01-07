package Trabalho.Mobile.Misc

enum class CaseTypes{
    MINITOWER,
    MIDTOWER,
    FULLTOWER,
    SUPERTOWER
}

class Case_Brand {

    var height: Double = 0.0
    var length: Double = 0.0
    var thickness:Double = 0.0

    lateinit var caseType:CaseTypes

}