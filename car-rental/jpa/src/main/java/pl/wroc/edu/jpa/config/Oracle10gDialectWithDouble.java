package pl.wroc.edu.jpa.config;

import java.sql.Types;

import org.hibernate.dialect.Oracle10gDialect;

public class Oracle10gDialectWithDouble extends Oracle10gDialect {

	public Oracle10gDialectWithDouble() {
		super(); 
	}
	
	@Override
	protected void registerNumericTypeMappings() {
		super.registerNumericTypeMappings();
		registerColumnType(Types.DOUBLE, "FLOAT");
	}
}
