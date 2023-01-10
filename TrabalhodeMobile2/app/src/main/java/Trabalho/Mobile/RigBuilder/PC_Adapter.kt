package Trabalho.Mobile.RigBuilder

import Trabalho.Mobile.Components.*

class PC_Adapter {

    lateinit var id:String
    var name : String? = null
    lateinit var cpu :CPU
    lateinit var gpu: GPU
    lateinit var motherBoard: MotherBoard

    constructor(id:String, name:String?){
        this.id = id
        this.name = name
    }

    constructor(id:String, name:String?, cpu: CPU,gpu: GPU,motherBoard: MotherBoard){
        this.id = id
        this.name = name
        this.cpu = cpu
        this.gpu = gpu
        this.motherBoard = motherBoard
    }
}