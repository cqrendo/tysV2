import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';

class TablasDescuentos extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }          
      vaadin-text-field.veryBig{
                width: var(--vaadin-text-field-default-width, 28em);
                margin-left: 5px;
      }
      
      vaadin-text-field.big{
                width: var(--vaadin-text-field-default-width, 20em);
                margin-left: 5px;
      }
      vaadin-text-field.medium{
                width: var(--vaadin-text-field-default-width, 10em);
                margin-left: 5px;
            }
      vaadin-text-field.veryVerySmall{
                width: var(--vaadin-text-field-default-width, 2em);
                margin-left: 5px;
            }
      vaadin-text-field.veryVerySmall3{
                width: var(--vaadin-text-field-default-width, 3em);
                margin-left: 5px;
            }
      vaadin-text-field.verySmall{
            width: var(--vaadin-text-field-default-width, 4em);  
 				margin-left: 5px;
             }  
      vaadin-text-field.verySmall5{
            width: var(--vaadin-text-field-default-width, 5em);  
 				margin-left: 5px;
             }  
      vaadin-text-field.small{
                width: var(--vaadin-text-field-default-width, 8em);
                margin-left: 5px;
            }  
      vaadin-date-picker {
      			width: var(--vaadin-text-field-default-width, 10em);
      			margin-left: 5px;
      }  
      div.linCampos {
/*       margin-top: 0px; */
      margin-left: 20px;
/*       height: 70px; */
/*       text-align:justify; */
/*       	display: flex;  */
      
/*        justify-content: left;  */
      } 
      div.lastColumn {
      float:right;
      margin-right:24px;
      }     
/*       vaadin-form-item{ */
/*       	background-color: rgba(0, 0, 0, 0.05); */
/*             }                 */
/* /*       vaadin-text-field { */ */
/* /*   	border: 10px solid gray; */ */
/*   	height:"100px""; */
  	
/* 		} */
	clean{
		padding-right:  0.75rem; margin-right: 0px;
	}
	/* Style the tab */
.tab {
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
}
				.cel {
        			display:inline-block;
        			width: 100%;
					min-width:320px;
				    padding: 1em;
				    text-align: center;
				    color: lightgray;
	            }
  page {
    display: flex;
    flex-direction: column;
    align-items: center;
    width:100%;
  }
fieldset {
    color: #9a3261;
    font-size: smaller;
    border: 1px solid #9a3261;
    width:100%;
}

    </style>
<div style="width: 100%; height: 100%;">
 <fieldset>
  <legend>Tablas Descuentos</legend>
  <div id="swedrfghjuik">
   <vaadin-text-field label="Clave" class="verySmall" id="col0"></vaadin-text-field>
   <vaadin-text-field label="Proveedor" class="small" id="col16"></vaadin-text-field>
   <vaadin-text-field label="Descripción" class="big" id="col13"></vaadin-text-field>
   <div style="display:inline-block;width:130px">
    <vaadin-text-field label="Patrón" class="small" style="display:block;" id="col14"></vaadin-text-field>
    <span style="display:block; width: 100%;" id="span2">Span</span>
    <span style="width: 100%;" id="span3">Span</span>
   </div>
   <vaadin-text-field label="Fec.Últ.Act.Borrador" class="medium" id="col15"></vaadin-text-field>
   <vaadin-button style="float:right;">
    <iron-icon icon="lumo:plus" slot="prefix"></iron-icon>Insertar Borrador 
   </vaadin-button>
  </div>
  <fieldset>
   <legend>Descuentos</legend>
   <div style="width: 120px; display:inline-block;">
    <vaadin-text-field class="verySmall" id="col1" label="A1"></vaadin-text-field>
    <vaadin-text-field class="verySmall" id="col2" label="A2"></vaadin-text-field>
    <vaadin-text-field class="verySmall" id="col3" label="A3"></vaadin-text-field>
    <vaadin-text-field class="verySmall" id="col4" label="A4"></vaadin-text-field>
   </div>
   <div style="width: 120px; display:inline-block;">
    <vaadin-text-field class="verySmall" id="col5" label="B1"></vaadin-text-field>
    <vaadin-text-field class="verySmall" id="col6" label="B2"></vaadin-text-field>
    <vaadin-text-field class="verySmall" id="col7" label="B3"></vaadin-text-field>
   </div>
   <div style="width: 120px; display:inline-block;">
    <vaadin-text-field class="verySmall" id="col8" label="C1"></vaadin-text-field>
    <vaadin-text-field class="verySmall" id="col9" label="C2"></vaadin-text-field>
   </div>
   <div style="width: 120px; display:inline-block;">
    <vaadin-text-field class="verySmall" id="col10" label="IncD1"></vaadin-text-field>
    <vaadin-text-field class="verySmall" id="col11" label="IncD2"></vaadin-text-field>
   </div>
  </fieldset>
 </fieldset>
 <div>
  <fieldset>
   <legend>Borrador</legend>
   <div style="display:inline-block;">
    <vaadin-text-field label="Clave" class="verySmall" id="col33"></vaadin-text-field>
    <vaadin-text-field label="Descripción" class="big" id="col31"></vaadin-text-field>
    <div style="display:inline-block;width:130px">
     <vaadin-text-field label="Patrón" class="small" style="display:block;" id="col32"></vaadin-text-field>
     <span style="display:block; width: 100%;" id="span1">A B C D</span>
     <span style="width: 100%;" id="span">12341231212</span>
    </div>
   </div>
   <fieldset style="width: 120px; display:inline-block;float:right;">
    <legend>Artículos</legend>
    <vaadin-button>
     <iron-icon icon="lumo:plus" slot="prefix"></iron-icon>Insertar Tabla Dtos. Borrador 
    </vaadin-button>
    <vaadin-button>
     <iron-icon icon="lumo:cross" slot="prefix"></iron-icon>Quitar Tabla Dtos. Borrador 
    </vaadin-button>
   </fieldset>
   <fieldset>
    <legend>Descuentos</legend>
    <div style="width: 120px; display:inline-block;">
     <vaadin-text-field class="verySmall" id="col19" label="A1"></vaadin-text-field>
     <vaadin-text-field class="verySmall" id="col20" label="A2"></vaadin-text-field>
     <vaadin-text-field class="verySmall" id="col21" label="A3"></vaadin-text-field>
     <vaadin-text-field class="verySmall" id="col22" label="A4"></vaadin-text-field>
    </div>
    <div style="width: 120px; display:inline-block;">
     <vaadin-text-field class="verySmall" id="col23" label="B1"></vaadin-text-field>
     <vaadin-text-field class="verySmall" id="col24" label="B2"></vaadin-text-field>
     <vaadin-text-field class="verySmall" id="col25" label="B3"></vaadin-text-field>
    </div>
    <div style="width: 120px; display:inline-block;">
     <vaadin-text-field class="verySmall" id="col26" label="C1"></vaadin-text-field>
     <vaadin-text-field class="verySmall" id="col27" label="C2"></vaadin-text-field>
    </div>
    <div style="width: 120px; display:inline-block;">
     <vaadin-text-field class="verySmall" id="col28" label="IncD1"></vaadin-text-field>
     <vaadin-text-field class="verySmall" id="col29" label="IncD2"></vaadin-text-field>
    </div>
   </fieldset>
  </fieldset>
 </div>
</div>
`;
    }

    static get is() {
        return 'tablas-descuentos';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(TablasDescuentos.is, TablasDescuentos);
