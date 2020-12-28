package website;

public class User {
		private int id = -1;
		private String name=null,password=null,email=null,sex=null,country=null;
		private String ststd=null;
		public String getStstd() {
			return ststd;
		}
		public void setStstd(String ststd) {
			this.ststd = ststd;
		}
		public User() {
			
		}
		public User(String ststd, int id, String name, String password, String email, String sex, String country) {
			super();
			this.id = id;
			this.ststd = ststd;
			this.name = name;
			this.password = password;
			this.email = email;
			this.sex = sex;
			this.country = country;
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
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
}
