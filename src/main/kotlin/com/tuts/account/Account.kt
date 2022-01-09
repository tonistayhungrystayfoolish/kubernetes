package com.tuts.account

import java.math.BigDecimal

data class Account(
    val accountNumber: Long,
    val customerNumber: Long,
    val customerName:String,
    val balance: BigDecimal,
    val accountStatus: AccountStatus = AccountStatus.OPEN
)

enum class AccountStatus{
    OPEN,
    CLOSED,
    OVERDRAWN
}