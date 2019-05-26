package fr.purplegiraffe.realmdemo

import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class Dog() : RealmObject() {
    var name:String = ""
    var age = 0

    fun addYears(years:Int) {
        age = age + 1
    }
}