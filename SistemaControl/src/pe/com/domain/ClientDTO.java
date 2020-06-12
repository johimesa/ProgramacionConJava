package pe.com.domain;

public class ClientDTO {
	
	private int id;
    private String name;
    private String lastname;
    private Double balance;

    public ClientDTO() {
    }

    public ClientDTO(int id) {
        this.id = id;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "ClientDTO [id=" + id + ", name=" + name + ", lastname=" + lastname + ", balance=" + balance + "]";
	}
}
