package com.tuts.account

import java.math.BigDecimal
import javax.annotation.PostConstruct
import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/accounts")
@ApplicationScoped
class AccountResource {
    private val accounts = hashSetOf<Account>()

    @PostConstruct
    fun setup(){
        accounts.add(
            Account(123532,
                123,
                "George",
                BigDecimal(23.04))
        )
        accounts.add(
            Account(1623,
                12673,
                "Toni",
                BigDecimal(45.14))
        )
    }

    @GET
    fun allAccounts() = accounts

    @GET
    @Path("/{accountNumber}")
    fun getAccount(@PathParam("accountNumber")  accountNumber: Long):List<Account>{
       return accounts.filter { it.accountNumber == accountNumber }
    }

}