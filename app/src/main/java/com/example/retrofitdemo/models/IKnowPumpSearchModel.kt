package com.example.retrofitdemo.models

import com.google.gson.annotations.SerializedName

data class IKnowPumpSearchModel (

    @SerializedName("freq") val freq : String,
    @SerializedName("brand") val brand : String,
    @SerializedName("full_name") val full_name : String,
    @SerializedName("series") val series : String,
    @SerializedName("impeller_code") val impeller_code : String,
    @SerializedName("impeller_type") val impeller_type : String,
    @SerializedName("pressure") val pressure : String,
    @SerializedName("impeller_no") val impeller_no : String,
    @SerializedName("phase_V") val phase_V : String,
    @SerializedName("nb_pole") val nb_pole : String,
    @SerializedName("atex") val atex : String,
    @SerializedName("inst_type") val inst_type : String,
    @SerializedName("in_A") val in_A : String,
    @SerializedName("P2") val p2 : String,
    @SerializedName("flow_BEP") val flow_BEP : String,
    @SerializedName("head_BEP") val head_BEP : String,
    @SerializedName("free_pass") val free_pass : String,
    @SerializedName("discharge") val discharge : String,
    @SerializedName("ref_KSB") val ref_KSB : String,
    @SerializedName("Q_range") val q_range : String,
    @SerializedName("atrex") val atrex : String,
    @SerializedName("P1") val p1 : String,
    @SerializedName("hydraulic_eff") val hydraulic_eff : String,
    @SerializedName("motor_eff") val motor_eff : String,
    @SerializedName("overall_eff") val overall_eff : String,
    @SerializedName("spec_energy") val spec_energy : String,
    @SerializedName("dn2") val dn2 : String,
    @SerializedName("adaptPA") val adaptPA : String,
    @SerializedName("id") val id : Int,
    @SerializedName("ref") val ref : Int
)