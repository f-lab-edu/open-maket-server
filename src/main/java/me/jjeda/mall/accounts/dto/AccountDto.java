package me.jjeda.mall.accounts.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import me.jjeda.mall.accounts.domain.Account;
import me.jjeda.mall.accounts.domain.AccountRole;
import me.jjeda.mall.accounts.domain.Address;

import java.time.LocalDateTime;

//@JsonIgnoreProperties({"email", "password", "phone", "address", "accountRole"})
@AllArgsConstructor
@Getter
@Builder
public class AccountDto {

    private String userName;
    /**
     * email, password, phone, Role, address 등은 개인정보로 직렬화하여 메시지에 담지 않는다.
     */
    private String email;

    private String password;

    private String phone;

    private AccountRole accountRole;

    private Address address;

    public Account toEntity() {
        return Account.builder()
                .userName(this.userName)
                .email(this.email)
                .password(this.password)
                .address(this.address)
                .phone(this.phone)
                .accountRole(this.accountRole)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
