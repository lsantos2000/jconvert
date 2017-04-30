<xs:schema attributeFormDefault="unqualified" elementFormDefault="qualified" xmlns:xs="http://www.w3.org/2001/XMLSchema">
  <xs:element name="records">
    <xs:complexType>
      <xs:sequence>
        <xs:element name="report" maxOccurs="unbounded" minOccurs="0">
          <xs:complexType>
            <xs:sequence>
              <xs:element type="xs:byte" name="packets-serviced"/>
              <xs:element type="xs:string" name="client-guid"/>
              <xs:element type="xs:byte" name="packets-requested"/>
              <xs:element type="xs:string" name="service-guid"/>
              <xs:element type="xs:byte" name="retries-request"/>
              <xs:element type="xs:string" name="request-time"/>
              <xs:element type="xs:string" name="client-address"/>
              <xs:element type="xs:byte" name="max-hole-size"/>
            </xs:sequence>
          </xs:complexType>
        </xs:element>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
</xs:schema>