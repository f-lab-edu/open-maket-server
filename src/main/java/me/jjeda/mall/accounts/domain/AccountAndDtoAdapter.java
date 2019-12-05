package me.jjeda.mall.accounts.domain;

import me.jjeda.mall.accounts.dto.AccountDto;

import java.time.LocalDateTime;
import java.util.Objects;

public class AccountAndDtoAdapter {


    public static AccountDto entityToDto(Account account) {
        return AccountDto.builder()
                .id(account.getId())
                .nickname(account.getNickname())
                .email(account.getEmail())
                .password(account.getPassword())
                .phone(account.getPhone())
                .accountRole(account.getAccountRole())
                .address(account.getAddress())
                .createAt(account.getCreatedAt())
                .status(account.getStatus())
                .build();
    }

    public static Account DtoToEntity(AccountDto accountDto) {

        if (Objects.isNull(accountDto.getId())) {
            return Account.builder()
                    .nickname(accountDto.getNickname())
                    .email(accountDto.getEmail())
                    .password(accountDto.getPassword())
                    .address(accountDto.getAddress())
                    .phone(accountDto.getPhone())
                    .accountRole(accountDto.getAccountRole())
                    .createdAt(LocalDateTime.now())
                    .status(AccountStatus.NORMAL)
                    .build();
        }
        return Account.builder()
                .id(accountDto.getId())
                .nickname(accountDto.getNickname())
                .email(accountDto.getEmail())
                .password(accountDto.getPassword())
                .address(accountDto.getAddress())
                .phone(accountDto.getPhone())
                .accountRole(accountDto.getAccountRole())
                .createdAt(accountDto.getCreateAt())
                .status(accountDto.getStatus())
                .build();
    }
}
