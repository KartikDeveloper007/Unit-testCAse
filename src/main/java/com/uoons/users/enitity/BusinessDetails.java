package com.uoons.users.enitity;

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
@Table(name = "business_details_TBL")
public class BusinessDetails extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "business_detail_id")
    private Long businessDetailId;
    @Column(name = "gst_number",unique = true)
    private String gstNumber;
    @Column(name = "pan_number",unique = true)
    private String panNumber;
    @Column(name = "seller_id")
    private Long sellerId;


}
