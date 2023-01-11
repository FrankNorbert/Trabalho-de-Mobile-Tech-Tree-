package Trabalho.Mobile.RigBuilder

import Trabalho.Mobile.Components.*

class PC {

    lateinit var id:String
    var name : String? = null
    lateinit var cpu :CPU
    lateinit var gpu: GPU
    lateinit var motherBoard: MotherBoard


    /**
     * Construtor de teste
     */
    constructor(id:String, name:String?){
        this.id = id
        this.name = name
    }


    /**
     * Construtor ainda a implementar
     */
    constructor(id:String, name:String?, cpu: CPU,gpu: GPU,motherBoard: MotherBoard){
        this.id = id
        this.name = name
        this.cpu = cpu
        this.gpu = gpu
        this.motherBoard = motherBoard
    }

    fun toHashmapPC() : HashMap <String, Any?>{
        return hashMapOf(
            "id" to id,
            "name" to name
        )
    }
}