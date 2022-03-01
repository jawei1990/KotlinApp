package com.example.interviewtest

class ItemModel {
    var name: String? = null
    var image: Int ?= null
    var color :Int?= null // 0: green, 1: blue, 2: red

    constructor(name:String,image:Int,color:Int)
    {
        this.name = name
        this.image = image
        this.color = color
    }
}