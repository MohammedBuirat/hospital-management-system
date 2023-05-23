![image](https://github.com/MohammedBuirat/hospital-management-system/assets/114314089/642a2159-076d-4268-ab8a-be516a6b9e14)
![Screenshot 2023-05-23 214942](https://github.com/MohammedBuirat/hospital-management-system/assets/114314089/639cec0f-2adb-43f6-9a4e-fe9dff5e2fb8)

<table>
  <tr>
    <th>HTTP method</th>
    <th>URL path</th>
    <th>HTTP Status Code</th>
    <th>description</th>
    <th>sample request</th>
    <th>sample response</th>
    <tr>
      <tr>
  <td>GET</td>
  <td>/get-all-appointments</td>
  <td>200 OK</td>
  <td>Retrieves all appointments</td>
  <td>N/A (No request body)</td>
  <td>
    <pre>
      Status: 200 OK
      Body: List of AppointmentDto objects representing the appointments
    </pre>
  </td>
</tr>
  <tr>
  <td>GET</td>
  <td>/get-appointment/{id}</td>
  <td>200 OK</td>
  <td>Retrieves an appointment by ID</td>
  <td>N/A (No request body)</td>
  <td>
    <pre>
      Status: 200 OK
      Body: AppointmentDto object representing the requested appointment
    </pre>
  </td>
</tr>
  <tr>
  <td>GET</td>
  <td>/get-all-bills</td>
  <td>200 OK</td>
  <td>Retrieves all bills</td>
  <td>N/A (No request body)</td>
  <td>
    <pre>
      Status: 200 OK
      Body: List of BillDto objects representing all the bills
    </pre>
  </td>
</tr>
  <tr>
  <td>GET</td>
  <td>/get-bill/{id}</td>
  <td>200 OK</td>
  <td>Retrieves a bill by ID</td>
  <td>N/A (No request body)</td>
  <td>
    <pre>
      Status: 200 OK
      Body: BillDto object representing the requested bill
    </pre>
  </td>
</tr>
  <tr>
  <td>DELETE</td>
  <td>/remove-bill/{id}</td>
  <td>200 OK</td>
  <td>Deletes a bill by ID</td>
  <td>N/A (No request body)</td>
  <td>
    <pre>
      Status: 200 OK
      Body: N/A (No response body)
    </pre>
  </td>
</tr>
  <tr>
  <td>PUT</td>
  <td>/update-bill/{id}</td>
  <td>200 OK</td>
  <td>Updates a bill by ID</td>
  <td>Request body: Map containing fields to update (e.g., "service", "paymentMethod", "insuranceDetails")</td>
  <td>
    <pre>
      Status: 200 OK
      Body: BillDto object representing the updated bill
    </pre>
  </td>
</tr>
  <tr>
  <td>POST</td>
  <td>/add-bill</td>
  <td>200 OK</td>
  <td>Adds a new bill</td>
  <td>Request body: Map containing bill details (e.g., "id", "chargeAmount", "service", "discount", "paymentMethod", "insuranceDetails", "patient")</td>
  <td>
    <pre>
      Status: 200 OK
      Body: Bill object representing the added bill
    </pre>
  </td>
</tr>
  <tr>
  <td>GET</td>
  <td>/get-all-medical-staff</td>
  <td>-</td>
  <td>Get all medical staff</td>
  <td>-</td>
  <td>
    <pre>
      Status: 200 OK
      Body: List of MedicalStaffDto objects representing the medical staff
    </pre>
  </td>
</tr>

<tr>
  <td>GET</td>
  <td>/get-medical-staff/{id}</td>
  <td>-</td>
  <td>Get medical staff by ID</td>
  <td>Path parameter: id (Integer) - ID of the medical staff</td>
  <td>
    <pre>
      Status: 200 OK
      Body: MedicalStaffDto object representing the medical staff with the given ID
    </pre>
  </td>
</tr>

<tr>
  <td>DELETE</td>
  <td>/remove-medical-staff/{id}</td>
  <td>-</td>
  <td>Delete medical staff by ID</td>
  <td>Path parameter: id (Integer) - ID of the medical staff</td>
  <td>
    <pre>
      Status: 200 OK
      Body: true if the medical staff was deleted successfully, false otherwise
    </pre>
  </td>
</tr>

<tr>
  <td>PUT</td>
  <td>/update-medical-staff/{id}</td>
  <td>-</td>
  <td>Update medical staff by ID</td>
  <td>
    Path parameter: id (Integer) - ID of the medical staff<br>
    Request body: Map containing medical staff details (e.g., "name", "gender", "speciality", "department")
  </td>
  <td>
    <pre>
      Status: 200 OK
      Body: MedicalStaffDto object representing the updated medical staff
    </pre>
  </td>
</tr>

<tr>
  <td>POST</td>
  <td>/add-medical-staff</td>
  <td>-</td>
  <td>Add a new medical staff</td>
  <td>
    Path parameter: id (Integer) - ID of the medical staff (generated automatically)<br>
    Request body: Map containing medical staff details (e.g., "name", "dateOfBirth", "gender", "address", "contactNumber", "speciality", "department")
  </td>
  <td>
    <pre>
      Status: 200 OK
      Body: MedicalStaffDto object representing the added medical staff
    </pre>
  </td>
</tr>
  <tr>
  <td>GET</td>
  <td>/get-all-patients</td>
  <td></td>
  <td>Get all patients</td>
  <td></td>
  <td>
    <pre>
      Status: 200 OK
      Body: List of PatientDto objects representing patients
    </pre>
  </td>
</tr>
<tr>
  <td>GET</td>
  <td>/get-patient/{id}</td>
  <td></td>
  <td>Get patient by ID</td>
  <td>Path variable: "id" (Integer)</td>
  <td>
    <pre>
      Status: 200 OK
      Body: PatientDto object representing the patient
      Status: 404 Not Found (if patient with the given ID doesn't exist)
    </pre>
  </td>
</tr>
<tr>
  <td>DELETE</td>
  <td>/remove-patient/{id}</td>
  <td></td>
  <td>Delete patient by ID</td>
  <td>Path variable: "id" (Integer)</td>
  <td>
    <pre>
      Status: 200 OK
      Body: true (if deletion is successful), false (if patient with the given ID doesn't exist)
    </pre>
  </td>
</tr>
<tr>
  <td>PUT</td>
  <td>/update-patient/{id}</td>
  <td></td>
  <td>Update patient by ID</td>
  <td>Path variable: "id" (Integer)</td>
  <td>
    <pre>
      Status: 200 OK
      Body: PatientDto object representing the updated patient
    </pre>
  </td>
</tr>
<tr>
  <td>POST</td>
  <td>/add-patient</td>
  <td></td>
  <td>Add a new patient</td>
  <td>Request body: Map containing patient details (e.g., "id", "name", "dateOfBirth", "gender", "address", "contactNumber", "diagnosis", "room", "admission", "medicalHistory", "discharge")</td>
  <td>
    <pre>
      Status: 200 OK
      Body: PatientDto object representing the added patient
    </pre>
  </td>
</tr>
  
  </table>
