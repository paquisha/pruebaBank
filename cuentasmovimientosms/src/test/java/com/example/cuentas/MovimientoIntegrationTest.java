package com.example.cuentas;

import com.example.cuentas.entity.Cuenta;
import com.example.cuentas.entity.Movimiento;
import com.example.cuentas.repository.CuentaRepository;
import com.example.cuentas.service.MovimientoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class MovimientoIntegrationTest {

    @Autowired
    private CuentaRepository cuentaRepo;

    @Autowired
    private MovimientoService movService;

    @Test
    public void testRegistrarMovimiento_insufficientBalance() {
        Cuenta c = new Cuenta();
        c.setNumeroCuenta("TST001");
        c.setTipoCuenta("Ahorros");
        c.setSaldoInicial(100.0);
        c.setEstado(true);
        c.setClienteId("jose123");
        cuentaRepo.save(c);

        Movimiento m = new Movimiento();
        m.setTipoMovimiento("Retiro");
        m.setValor(-150.0);

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            movService.registrarMovimiento("TST001", m);
        });
        assertThat(ex.getMessage()).isEqualTo("Saldo no disponible");
    }
}
