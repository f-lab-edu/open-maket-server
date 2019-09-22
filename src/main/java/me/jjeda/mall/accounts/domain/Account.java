package me.jjeda.mall.accounts.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.jjeda.mall.accounts.dto.AccountDto;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String nickname;

    private String email;

    private String password;

    private String phone;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<AccountRole> accountRole;

    /**
     * 회원(구매측)뿐만아니라 회사(판매측) 등 재사용성을 위해 값타입으로 매핑
     */
    @Embedded
    private Address address;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    public void update(AccountDto accountDto) {
        this.nickname = accountDto.getNickname();
        this.address = accountDto.getAddress();
        this.password = accountDto.getPassword();
        this.accountRole = accountDto.getAccountRole();
        this.phone = accountDto.getPhone();
        this.email = accountDto.getEmail();
        this.modifiedAt = LocalDateTime.now();
    }
}