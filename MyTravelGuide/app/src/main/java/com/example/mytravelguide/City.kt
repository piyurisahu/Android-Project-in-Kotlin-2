package com.example.mytravelguide


class City{
    var city:String?=null
    var hotel:String?=null
    var state:String?=null
    var description:String?=null
    var weather:String? = null
    var image:Int?=null
    constructor(city:String ,hotel:String ,description:String, weather:String, state: String, image:Int){
        this.city = city
        this.hotel = hotel
        this.description = description
        this.weather = weather
        this.state = state
        this.image=image
    }
}
