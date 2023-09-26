package com.example.diplomaproject.services;

import com.example.diplomaproject.entity.Wallet;
import com.example.diplomaproject.entity.WalletTransaction;
import com.example.diplomaproject.repository.WalletTransactionRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class WalletTransitionService {

    private final WalletTransactionRepository walletTransactionRepository;

    public WalletTransitionService(WalletTransactionRepository walletTransactionRepository) {
        this.walletTransactionRepository = walletTransactionRepository;
    }

    @Transactional
    public void save(WalletTransaction walletTransaction){
        walletTransactionRepository.save(walletTransaction);
    }

    @Transactional(readOnly = true)
    public List<WalletTransaction> findWalletTransactionsByWalletId(Long walletId, int page, int number){
        PageRequest pageRequest = PageRequest.of(page, number, Sort.by("id").descending());
        return walletTransactionRepository.findWalletTransactionsByWalletId(walletId, pageRequest);
    }

    @Transactional(readOnly = true)
    public List<WalletTransaction> findWalletTransactionsByWallet(Wallet wallet){


        return walletTransactionRepository.findWalletTransactionByWallet(wallet);
    }

    @Transactional
    public void deleteWalletTransactionsByWalletId(Long id){
        walletTransactionRepository.deleteWalletTransactionByWalletId(id);
    }

    @Transactional
    public boolean delete(WalletTransaction wt){
        walletTransactionRepository.delete(wt);
        return true;
    }


    @Transactional
    public WalletTransaction findWalletTransactionById(Long id){

       return walletTransactionRepository.findWalletTransactionById(id);
    }

}
