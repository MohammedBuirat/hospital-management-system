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
  
  </table>
