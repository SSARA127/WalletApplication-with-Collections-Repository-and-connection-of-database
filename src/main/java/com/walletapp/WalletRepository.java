package com.walletapp;

public interface WalletRepository {
    WalletDto createWallet(WalletDto newWallet);
    WalletDto getWalletById(Integer  walletId);
    WalletDto updateWallet(WalletDto wallet);
    WalletDto deleteWalletById(Integer walletId);
}
