package Trabalho.Mobile.ActivityHandling

import Trabalho.Mobile.MainComponents.Graphics_Card_Brand

class GPU_Comparison {

    lateinit var gpus : ArrayList<Graphics_Card_Brand>

    fun relativePerformance(gpu1: Graphics_Card_Brand, gpu2: Graphics_Card_Brand){

    }

    fun gpuCompare(gpu1:Graphics_Card_Brand, gpu2:Graphics_Card_Brand) : Graphics_Card_Brand? {
        var gpuToReturn : Graphics_Card_Brand? = null
        if(gpu1.amountOfCores > gpu2.amountOfCores && gpu1.frequency > gpu2.frequency && gpu1.memoryBus > gpu2.memoryBus){
            gpuToReturn = gpu1
        }
        else{
            gpuToReturn = gpu2
        }
        return gpuToReturn
    }
}