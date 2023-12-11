package com.example.lab11_ngotruongvu;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class Danhsachnhanvien extends AppCompatActivity {

    private EmployeeHelper employeeHelper;
    private ListView listView;
    private ArrayAdapter<Employee> arrayAdapter;
    private List<Employee> employeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachnhanvien);

        employeeHelper = new EmployeeHelper(this);

        // Thêm dữ liệu mẫu
        employeeHelper.addEmployee(new Employee("NV-001", "Nguyễn Đại Nhân", 30));
        employeeHelper.addEmployee(new Employee("NV-002", "Trần Đại Nghĩa", 28));
        employeeHelper.addEmployee(new Employee("NV-003", "Hoàng Đại Lễ", 27));
        employeeHelper.addEmployee(new Employee("NV-004", "Phạm Đại Trí", 25));
        employeeHelper.addEmployee(new Employee("NV-005", "Trương Đại Tín", 34));
        employeeHelper.addEmployee(new Employee("NV-006", "Hồ Đại Đức", 29));
        listView = findViewById(R.id.listViewEmployees);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Employee employee = arrayAdapter.getItem(position);
                showEmployeeDetails(employee);
                return true;
            }
        });

        loadEmployees();
    }

    private void loadEmployees() {
        employeeList = employeeHelper.getAllEmployees();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, employeeList);
        listView.setAdapter(arrayAdapter);
    }

    private void showEmployeeDetails(Employee employee) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.activity_thongtinnhanvien, null);
        builder.setView(dialogView);

        EditText editTextId = dialogView.findViewById(R.id.editTextId);
        EditText editTextName = dialogView.findViewById(R.id.editTextName);
        EditText editTextAge = dialogView.findViewById(R.id.editTextAge);

        editTextId.setText(employee.getId());
        editTextName.setText(employee.getName());
        editTextAge.setText(String.valueOf(employee.getAge()));

        builder.setNeutralButton("Xóa nhân viên", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                employeeHelper.deleteEmployee(employee);
                Toast.makeText(Danhsachnhanvien.this, "Đã xóa nhân viên", Toast.LENGTH_SHORT).show();
                loadEmployees();
            }
        });

        builder.setNegativeButton("Trở về", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}