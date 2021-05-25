package hellojpa;

import hellojpa.embedded.Address;
import hellojpa.embedded.Period;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String name;

    // 기간
    @Embedded
    private Period workPeriod;

    // 집 주소
    @Embedded
    private Address homeAddress;

    // 직장 주소
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name ="city",
//                        column = @Column(name="WORK_CITY")),
//            @AttributeOverride(name ="street",
//                    column = @Column(name="WORK_STREET")),
//            @AttributeOverride(name ="zipcode",
//                    column = @Column(name="WORK_ZIPCODE")),
//    })
//    private Address workAddress;

    @ElementCollection
    @CollectionTable(name ="FAVORITE_FOOD", joinColumns =
            @JoinColumn(name="MEMBER_ID"))
    private Set<String> favoriteFoods = new HashSet<>();

//    @ElementCollection
//    @CollectionTable(name ="ADDRESS", joinColumns =
//    @JoinColumn(name="MEMBER_ID"))
//    private List<Address> addressHistory = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();

    public List<AddressEntity> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<AddressEntity> addressHistory) {
        this.addressHistory = addressHistory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Period getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Period workPeriod) {
        this.workPeriod = workPeriod;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

}
