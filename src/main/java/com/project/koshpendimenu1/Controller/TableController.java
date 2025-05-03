package com.project.koshpendimenu1.Controller;

import com.project.koshpendimenu1.Model.Tables;
import com.project.koshpendimenu1.Service.TableService.ITableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tables")  // Base URL for table-related endpoints
public class TableController {

    private final ITableService tableService;

    public TableController(ITableService tableService) {
        this.tableService = tableService;
    }

    // Add a new table
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tables addTable(@RequestBody Tables table) {
        return tableService.addTable(table);
    }

    // Get a table by ID
    @GetMapping("/{id}")
    public Optional<Tables> getTableById(@PathVariable Long id) {
        return tableService.getTableById(id);
    }

    // Get all tables
    @GetMapping
    public Iterable<Tables> getAllTables() {
        return tableService.getAllTables();
    }

    // Update an existing table
    @PutMapping("/{id}")
    public Tables updateTable(@PathVariable Long id, @RequestBody Tables updatedTable) {
        return tableService.updateTable(id, updatedTable);
    }

    // Delete a table by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTable(@PathVariable Long id) {
        tableService.deleteTable(id);
    }
}
