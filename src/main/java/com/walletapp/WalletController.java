package com.walletapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping(value = "/v1") //
public class WalletController {
    @Autowired
    private WalletService walletService ;
    @GetMapping("/message")
    public String greet(){
        return "Welcome to wallet my app!";
    }

    @GetMapping("/getwallet/{id}/{password}")
    public WalletDto getEmployeeById(@PathVariable Integer id,@PathVariable String password) throws WalletException{
        return walletService.getWalletById(id,password);
    }
    @PostMapping("/addwallet")
    public WalletDto addResource(@Valid @RequestBody WalletDto wallet) throws WalletException {
        return walletService.registerWallet(wallet);
    }

    @PutMapping("/updatewallet/{password}")
    public WalletDto replaceResource(@RequestBody WalletDto wallet,@PathVariable String password) throws WalletException {
        return walletService.updateWallet(wallet,password);
    }

    @DeleteMapping("/deletewallet/{walletId}/{password}")
    public WalletDto deleteResource(@PathVariable("walletId") Integer walletId,@PathVariable String password ) throws WalletException {

        return walletService.deleteWalletById(walletId, password);
    }
    @PatchMapping("/patchwallet/{id}/name/{walletName}/{password}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public String updateResourceName(@PathVariable("id") Integer walletId,@PathVariable("walletName") String walletName,@PathVariable String password){
        return "Patch !"+walletId+":"+walletName;
    }
    @PostMapping("/addfundstowallet/{id}/amount/{amount}/password/{password}")
    public WalletDto addFundsToResource(@PathVariable Integer id,@PathVariable Double amount,@PathVariable String password)throws WalletException{
        return walletService.addFundsToWalletById(id,amount,password);
    }
    @PostMapping("/withdrawfundsfromwallet/{id}/amount/{amount}/password/{password}")
    public WalletDto withdrawFundsFromResource(@PathVariable Integer id,@PathVariable Double amount,@PathVariable String password) throws WalletException{
        return walletService.withdrawFundsFromWalletById(id,amount,password);
    }
    @PostMapping("/transferfundsBywallet/fromwalletId/{fromwalletId}/towalletId/{towalletId}/amount/{amount}/password/{password}")
    public String TransferfundsfromResource(@PathVariable Integer fromwalletId,@PathVariable Integer towalletId,@PathVariable Double amount,@PathVariable String password)throws WalletException{
        return walletService.fundTransfer(fromwalletId,towalletId,amount,password);
    }
    @GetMapping("/getAllwallet/password/{password}")
    public List<WalletDto> getAllWallets(@PathVariable String password)throws WalletException{
        return walletService.getAllWallets(password);
    }

}
