package lv.venta.models.security;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.annotations.Parent;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Table(name = "MyAuthority") //DB pusē izveidosies tabula
@Entity
public class MyAuthority {
	
	@Column(name = "MyAuthorityId")  //DB pusē būs kolona "id" un būs kā auto increment PK
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int MyAuthorityId;
	
	@Column(name="Title")
	@NotNull
	@Pattern(regexp = "[A-Z]{3,8}")
	private String title;
	
	@ManyToMany
	@JoinTable(name = "User_Authorities", joinColumns = @JoinColumn(name = "MyAuthorityId"), inverseJoinColumns = @JoinColumn(name ="MyUserId"))
	private Collection<MyUser> users = new ArrayList<>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMyAuthorityId() {
		return MyAuthorityId;
	}
	
	public MyAuthority(){}
	
	public MyAuthority(String title){
		setTitle(title);
	}
	
	public void addUser(MyUser user) {
        if(!users.contains(user)) {
                users.add(user);
        }
	}
	 public void removeUser(MyUser user) {
	         if(users.contains(user)) {
	                 users.remove(user);
	         }
	 }
	
	

}
