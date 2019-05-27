package fr.purplegiraffe.tvcharacters

import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class Character() : RealmObject() {
    var name:String = ""
    var show:String = ""

    constructor(name:String, show:String) : this() {
        this.name = name
        this.show = show
    }
}