package com.walletapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WalletRepositoryTest {
    @Autowired
    private WalletRepository walletRepository;
    LocalDate n = LocalDate.now();

    @BeforeEach
    public void init() {
        this.walletRepository.createWallet(new WalletDto(1, "saravanan", "googlepay", "saravanan@gmail.com", "Sara@123", "9384196731", n, 35000.00));
    }

    @Test
    public void createWalletTest() {
        WalletDto wallet = this.walletRepository.createWallet(new WalletDto(1, "saravanan", "googlepay", "saravanan@gmail.com", "Sara@123", "9384196731", n, 35000.00));
        assertEquals("saravanan", wallet.getName_Of_Holder());
    }

    @Test
    public void getWalletByIdTest() {

        assertEquals("saravanan", walletRepository.getWalletById(1).getName_Of_Holder());
    }

    @Test
    public void deleteWalletByIdTest() {
        WalletDto deletedWallet = walletRepository.deleteWalletById(1);
        assertEquals("saravanan", deletedWallet.getName_Of_Holder());
    }

    @Test
    void updateWalletTest() {
        WalletDto updatedwallet = this.walletRepository.updateWallet(new WalletDto(1, "santhosh", "googlepay", "saravanan@gmail.com", "Sara@123", "9384196731", n, 35000.00));
        WalletDto d = walletRepository.getWalletById(1);
        assertEquals("santhosh", d.getName_Of_Holder());
    }

    @Test
    void updateWalletTest1() {
        WalletDto oldwallet = this.walletRepository.createWallet(new WalletDto(1, "saravanan", "googlepay", "saravanan@gmail.com", "Sara@123", "9384196731", n, 35000.00));
        WalletDto updatedwallet = this.walletRepository.updateWallet(new WalletDto(1, "santhosh", "googlepay", "saravanan@gmail.com", "Sara@123", "9384196731", n, 35000.00));
        WalletDto d = walletRepository.getWalletById(1);
        assertEquals("santhosh", d.getName_Of_Holder());
    }
}
