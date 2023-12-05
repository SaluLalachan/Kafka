/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.employees.Employee.kafka.avro.model;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class VehicleDetails extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -7736802382623460705L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"VehicleDetails\",\"namespace\":\"com.employees.Employee.kafka.avro.model\",\"fields\":[{\"name\":\"id\",\"type\":\"int\"},{\"name\":\"VehicleNumber\",\"type\":\"string\"},{\"name\":\"VehicleName\",\"type\":\"string\"},{\"name\":\"InsuranceDetails\",\"type\":\"string\"},{\"name\":\"ManufacturingYear\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<VehicleDetails> ENCODER =
      new BinaryMessageEncoder<VehicleDetails>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<VehicleDetails> DECODER =
      new BinaryMessageDecoder<VehicleDetails>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<VehicleDetails> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<VehicleDetails> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<VehicleDetails>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this VehicleDetails to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a VehicleDetails from a ByteBuffer. */
  public static VehicleDetails fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public int id;
  @Deprecated public java.lang.CharSequence VehicleNumber;
  @Deprecated public java.lang.CharSequence VehicleName;
  @Deprecated public java.lang.CharSequence InsuranceDetails;
  @Deprecated public java.lang.CharSequence ManufacturingYear;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public VehicleDetails() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param VehicleNumber The new value for VehicleNumber
   * @param VehicleName The new value for VehicleName
   * @param InsuranceDetails The new value for InsuranceDetails
   * @param ManufacturingYear The new value for ManufacturingYear
   */
  public VehicleDetails(java.lang.Integer id, java.lang.CharSequence VehicleNumber, java.lang.CharSequence VehicleName, java.lang.CharSequence InsuranceDetails, java.lang.CharSequence ManufacturingYear) {
    this.id = id;
    this.VehicleNumber = VehicleNumber;
    this.VehicleName = VehicleName;
    this.InsuranceDetails = InsuranceDetails;
    this.ManufacturingYear = ManufacturingYear;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return VehicleNumber;
    case 2: return VehicleName;
    case 3: return InsuranceDetails;
    case 4: return ManufacturingYear;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.Integer)value$; break;
    case 1: VehicleNumber = (java.lang.CharSequence)value$; break;
    case 2: VehicleName = (java.lang.CharSequence)value$; break;
    case 3: InsuranceDetails = (java.lang.CharSequence)value$; break;
    case 4: ManufacturingYear = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.Integer getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.Integer value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'VehicleNumber' field.
   * @return The value of the 'VehicleNumber' field.
   */
  public java.lang.CharSequence getVehicleNumber() {
    return VehicleNumber;
  }

  /**
   * Sets the value of the 'VehicleNumber' field.
   * @param value the value to set.
   */
  public void setVehicleNumber(java.lang.CharSequence value) {
    this.VehicleNumber = value;
  }

  /**
   * Gets the value of the 'VehicleName' field.
   * @return The value of the 'VehicleName' field.
   */
  public java.lang.CharSequence getVehicleName() {
    return VehicleName;
  }

  /**
   * Sets the value of the 'VehicleName' field.
   * @param value the value to set.
   */
  public void setVehicleName(java.lang.CharSequence value) {
    this.VehicleName = value;
  }

  /**
   * Gets the value of the 'InsuranceDetails' field.
   * @return The value of the 'InsuranceDetails' field.
   */
  public java.lang.CharSequence getInsuranceDetails() {
    return InsuranceDetails;
  }

  /**
   * Sets the value of the 'InsuranceDetails' field.
   * @param value the value to set.
   */
  public void setInsuranceDetails(java.lang.CharSequence value) {
    this.InsuranceDetails = value;
  }

  /**
   * Gets the value of the 'ManufacturingYear' field.
   * @return The value of the 'ManufacturingYear' field.
   */
  public java.lang.CharSequence getManufacturingYear() {
    return ManufacturingYear;
  }

  /**
   * Sets the value of the 'ManufacturingYear' field.
   * @param value the value to set.
   */
  public void setManufacturingYear(java.lang.CharSequence value) {
    this.ManufacturingYear = value;
  }

  /**
   * Creates a new VehicleDetails RecordBuilder.
   * @return A new VehicleDetails RecordBuilder
   */
  public static com.employees.Employee.kafka.avro.model.VehicleDetails.Builder newBuilder() {
    return new com.employees.Employee.kafka.avro.model.VehicleDetails.Builder();
  }

  /**
   * Creates a new VehicleDetails RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new VehicleDetails RecordBuilder
   */
  public static com.employees.Employee.kafka.avro.model.VehicleDetails.Builder newBuilder(com.employees.Employee.kafka.avro.model.VehicleDetails.Builder other) {
    return new com.employees.Employee.kafka.avro.model.VehicleDetails.Builder(other);
  }

  /**
   * Creates a new VehicleDetails RecordBuilder by copying an existing VehicleDetails instance.
   * @param other The existing instance to copy.
   * @return A new VehicleDetails RecordBuilder
   */
  public static com.employees.Employee.kafka.avro.model.VehicleDetails.Builder newBuilder(com.employees.Employee.kafka.avro.model.VehicleDetails other) {
    return new com.employees.Employee.kafka.avro.model.VehicleDetails.Builder(other);
  }

  /**
   * RecordBuilder for VehicleDetails instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<VehicleDetails>
    implements org.apache.avro.data.RecordBuilder<VehicleDetails> {

    private int id;
    private java.lang.CharSequence VehicleNumber;
    private java.lang.CharSequence VehicleName;
    private java.lang.CharSequence InsuranceDetails;
    private java.lang.CharSequence ManufacturingYear;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.employees.Employee.kafka.avro.model.VehicleDetails.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.VehicleNumber)) {
        this.VehicleNumber = data().deepCopy(fields()[1].schema(), other.VehicleNumber);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.VehicleName)) {
        this.VehicleName = data().deepCopy(fields()[2].schema(), other.VehicleName);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.InsuranceDetails)) {
        this.InsuranceDetails = data().deepCopy(fields()[3].schema(), other.InsuranceDetails);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.ManufacturingYear)) {
        this.ManufacturingYear = data().deepCopy(fields()[4].schema(), other.ManufacturingYear);
        fieldSetFlags()[4] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing VehicleDetails instance
     * @param other The existing instance to copy.
     */
    private Builder(com.employees.Employee.kafka.avro.model.VehicleDetails other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.VehicleNumber)) {
        this.VehicleNumber = data().deepCopy(fields()[1].schema(), other.VehicleNumber);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.VehicleName)) {
        this.VehicleName = data().deepCopy(fields()[2].schema(), other.VehicleName);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.InsuranceDetails)) {
        this.InsuranceDetails = data().deepCopy(fields()[3].schema(), other.InsuranceDetails);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.ManufacturingYear)) {
        this.ManufacturingYear = data().deepCopy(fields()[4].schema(), other.ManufacturingYear);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.Integer getId() {
      return id;
    }

    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.employees.Employee.kafka.avro.model.VehicleDetails.Builder setId(int value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.employees.Employee.kafka.avro.model.VehicleDetails.Builder clearId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'VehicleNumber' field.
      * @return The value.
      */
    public java.lang.CharSequence getVehicleNumber() {
      return VehicleNumber;
    }

    /**
      * Sets the value of the 'VehicleNumber' field.
      * @param value The value of 'VehicleNumber'.
      * @return This builder.
      */
    public com.employees.Employee.kafka.avro.model.VehicleDetails.Builder setVehicleNumber(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.VehicleNumber = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'VehicleNumber' field has been set.
      * @return True if the 'VehicleNumber' field has been set, false otherwise.
      */
    public boolean hasVehicleNumber() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'VehicleNumber' field.
      * @return This builder.
      */
    public com.employees.Employee.kafka.avro.model.VehicleDetails.Builder clearVehicleNumber() {
      VehicleNumber = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'VehicleName' field.
      * @return The value.
      */
    public java.lang.CharSequence getVehicleName() {
      return VehicleName;
    }

    /**
      * Sets the value of the 'VehicleName' field.
      * @param value The value of 'VehicleName'.
      * @return This builder.
      */
    public com.employees.Employee.kafka.avro.model.VehicleDetails.Builder setVehicleName(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.VehicleName = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'VehicleName' field has been set.
      * @return True if the 'VehicleName' field has been set, false otherwise.
      */
    public boolean hasVehicleName() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'VehicleName' field.
      * @return This builder.
      */
    public com.employees.Employee.kafka.avro.model.VehicleDetails.Builder clearVehicleName() {
      VehicleName = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'InsuranceDetails' field.
      * @return The value.
      */
    public java.lang.CharSequence getInsuranceDetails() {
      return InsuranceDetails;
    }

    /**
      * Sets the value of the 'InsuranceDetails' field.
      * @param value The value of 'InsuranceDetails'.
      * @return This builder.
      */
    public com.employees.Employee.kafka.avro.model.VehicleDetails.Builder setInsuranceDetails(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.InsuranceDetails = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'InsuranceDetails' field has been set.
      * @return True if the 'InsuranceDetails' field has been set, false otherwise.
      */
    public boolean hasInsuranceDetails() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'InsuranceDetails' field.
      * @return This builder.
      */
    public com.employees.Employee.kafka.avro.model.VehicleDetails.Builder clearInsuranceDetails() {
      InsuranceDetails = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'ManufacturingYear' field.
      * @return The value.
      */
    public java.lang.CharSequence getManufacturingYear() {
      return ManufacturingYear;
    }

    /**
      * Sets the value of the 'ManufacturingYear' field.
      * @param value The value of 'ManufacturingYear'.
      * @return This builder.
      */
    public com.employees.Employee.kafka.avro.model.VehicleDetails.Builder setManufacturingYear(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.ManufacturingYear = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'ManufacturingYear' field has been set.
      * @return True if the 'ManufacturingYear' field has been set, false otherwise.
      */
    public boolean hasManufacturingYear() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'ManufacturingYear' field.
      * @return This builder.
      */
    public com.employees.Employee.kafka.avro.model.VehicleDetails.Builder clearManufacturingYear() {
      ManufacturingYear = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public VehicleDetails build() {
      try {
        VehicleDetails record = new VehicleDetails();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.Integer) defaultValue(fields()[0]);
        record.VehicleNumber = fieldSetFlags()[1] ? this.VehicleNumber : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.VehicleName = fieldSetFlags()[2] ? this.VehicleName : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.InsuranceDetails = fieldSetFlags()[3] ? this.InsuranceDetails : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.ManufacturingYear = fieldSetFlags()[4] ? this.ManufacturingYear : (java.lang.CharSequence) defaultValue(fields()[4]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<VehicleDetails>
    WRITER$ = (org.apache.avro.io.DatumWriter<VehicleDetails>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<VehicleDetails>
    READER$ = (org.apache.avro.io.DatumReader<VehicleDetails>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
