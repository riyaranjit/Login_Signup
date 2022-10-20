package com.example.activityflow


fun String?.addEmptyValueIfNull():String{
    if(this.isNullOrEmpty()){
        return ""
    }
    return this
}