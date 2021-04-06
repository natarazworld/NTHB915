//Traveller.java
package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ALL_COLLECTION_ANNO_TRAVELLER")
public class Traveller implements Serializable {
	@Id
	@GeneratedValue
	private  Integer travellerId;
	@NonNull
	@Column(length = 15)
	private  String travellerName;
	@NonNull
	private  LocalDateTime  dob;
	
	@NonNull
	@OrderColumn(name = "NICKNAME_INDEX")
	@ListIndexBase(value = 1)
	@ElementCollection
	@JoinColumn(name = "TRAVELLER_ID",referencedColumnName = "TRAVELLERID")
	@CollectionTable(name = "ALL_COLLECTION_NICKNAMES")
	private List<String>  nickNames;
	
	@NonNull
	@OrderColumn(name = "PHOME_INDEX")
	@ElementCollection
	@JoinColumn(name = "TRAVELLER_ID",referencedColumnName = "TRAVELLERID")
	@CollectionTable(name = "ALL_COLLECTION_PHONES")
	private  Set<Long> phones;
	
	@NonNull
	@JoinColumn(name = "TRAVELLER_ID",referencedColumnName = "TRAVELLERID")
	@MapKeyColumn(name = "TOUR_NAME",length = 25)
	@ElementCollection
	@CollectionTable(name = "ALL_COLLECTION_TOURPLACES")
	private  Map<String,String> placesVisited;
	

}
