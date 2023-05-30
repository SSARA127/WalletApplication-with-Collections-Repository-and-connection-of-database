package com.walletapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.BDDMockito.given;
@SpringBootTest
public class WalletServiceByMockRepository {
    @Autowired
    private WalletService walletService;
    @MockBean
    private WalletRepositoryImpl walletRepositoryImpl;
    LocalDate n=LocalDate.now();
    @Test
    public void testServiceWithOutActualRepository() throws WalletException{
        given(this.walletRepositoryImpl.getWalletById(1))
                .willReturn(new WalletDto(1, "saravanan","googlepay", "saravanan@gmail.com", "Sara@123", "9384196731", n,35000.00));
        assertEquals("saravanan",this.walletService.getWalletById(1,"Sara@123").getName_Of_Holder());
    }

    @Test
    public void testGetWalletThrowsExceptionTest() throws WalletException{

        given(this.walletRepositoryImpl.getWalletById(200))
                .willReturn(null);
        assertThrows(WalletException.class,()->walletService.getWalletById(200,"Sara@123"));
    }
}
