package com.uoons.users.enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uoons.users.dto.AddressType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address_TBL")
public class AddressEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;
    @Column(name = "house_no")
    private String hosueNo;
    @Column(name = "area")
    private String area;
    @Column(name = "landmark")
    private String landmark;
    @Column(name = "alternate_mobile")
    private String alternateMobileNo;

    @JsonIgnore
    @Column(name = "address_type")
    private String addressType;
    @Column(name = "pincode")
    private String pincode;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;

    @JsonIgnore
    @Column(name = "is_primary_address")
    private boolean isPrimaryAddress = true;
    @Column(name = "user_id")
    private Long userId;


}
