package pojoForSerializationAndDeSerialization;

public class EmpDetailsArrayWithObject 
{
	//Step 1 : declare all necessary variable as global
			String name;
			String empId;
			String email;
			int[] phono;
			String designation;
			Object children;
			public EmpDetailsArrayWithObject(String name, String empId, String email, int[] phono, String designation,
					Object children) {
				super();
				this.name = name;
				this.empId = empId;
				this.email = email;
				this.phono = phono;
				this.designation = designation;
				this.children = children;
			}
				
				public EmpDetailsArrayWithObject()
				{
					
				}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getEmpId() {
				return empId;
			}
			public void setEmpId(String empId) {
				this.empId = empId;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public int[] getPhono() {
				return phono;
			}
			public void setPhono(int[] phono) {
				this.phono = phono;
			}
			public String getDesignation() {
				return designation;
			}
			public void setDesignation(String designation) {
				this.designation = designation;
			}
			public Object getChildren() {
				return children;
			}
			public void setChildren(Object children) {
				this.children = children;
			}
			
			
}
