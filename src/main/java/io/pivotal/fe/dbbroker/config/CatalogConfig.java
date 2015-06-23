package io.pivotal.fe.dbbroker.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cloudfoundry.community.servicebroker.model.Catalog;
import org.cloudfoundry.community.servicebroker.model.Plan;
import org.cloudfoundry.community.servicebroker.model.ServiceDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CatalogConfig {

	@Bean
	public Catalog catalog() {
		return new Catalog(Arrays.asList(new ServiceDefinition("db-broker",
				"db-broker", "Provides db connection strings", true, false,
				Arrays.asList(new Plan("location-x", "location-x",
						"This is a db-broker plan for location-x.",
						getLocationXPlanMetadata(), true), new Plan(
						"location-y", "location-y",
						"This is a db-broker plan for location-y.",
						getLocationYPlanMetadata(), true), new Plan(
						"location-z", "location-z",
						"This is a db-broker plan for location-z.",
						getLocationZPlanMetadata())), 
						Arrays.asList(
						"db-broker", "uri"), getServiceDefinitionMetadata(),
				null, null)));
	}

	/* Used by Pivotal CF console */

	private Map<String, Object> getServiceDefinitionMetadata() {
		Map<String, Object> sdMetadata = new HashMap<String, Object>();
		sdMetadata.put("displayName", "DB-Broker");
		sdMetadata
				.put("imageUrl",
						"https://dtb5pzswcit1e.cloudfront.net/assets/images/product_logos/icon_cf_green@2x.png");
		sdMetadata.put("longDescription", "DB-Broker Service");
		sdMetadata.put("providerDisplayName", "Pivotal");
		sdMetadata.put("documentationUrl", "http://www.pivotal.io");
		sdMetadata.put("supportUrl", "http://www.pivotal.io");
		return sdMetadata;
	}

	private Map<String, Object> getLocationXPlanMetadata() {
		Map<String, Object> planMetadata = new HashMap<String, Object>();
		planMetadata.put("costs", getCosts());
		planMetadata.put("bullets", getLocationXBullets());
		return planMetadata;
	}

	private Map<String, Object> getLocationYPlanMetadata() {
		Map<String, Object> planMetadata = new HashMap<String, Object>();
		planMetadata.put("costs", getCosts());
		planMetadata.put("bullets", getLocationYBullets());
		return planMetadata;
	}

	private Map<String, Object> getLocationZPlanMetadata() {
		Map<String, Object> planMetadata = new HashMap<String, Object>();
		planMetadata.put("costs", getCosts());
		planMetadata.put("bullets", getLocationZBullets());
		return planMetadata;
	}
	
	private List<Map<String, Object>> getCosts() {
		Map<String, Object> costsMap = new HashMap<String, Object>();

		Map<String, Object> amount = new HashMap<String, Object>();
		amount.put("usd", new Double(0.0));

		costsMap.put("amount", amount);
		costsMap.put("unit", "MONTHLY");

		return Arrays.asList(costsMap);
	}

	private List<String> getLocationXBullets() {
		return Arrays.asList("DB connection for Location-X", "additional info",
				"additional info");
	}

	private List<String> getLocationYBullets() {
		return Arrays.asList("DB connection for Location-Y",
				"additional info", "additional info");
	}

	private List<String> getLocationZBullets() {
		return Arrays.asList("DB connection for Location-Z",
				"additional info", "additional info");
	}

}