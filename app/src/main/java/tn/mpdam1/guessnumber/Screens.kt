package tn.mpdam1.guessnumber

sealed class Screens(var route: String){
    object Home:Screens(route="home_screen")
    object basic:Screens(route= "basic_screen")
    object advanced:Screens(route="advanced_screen")
}
