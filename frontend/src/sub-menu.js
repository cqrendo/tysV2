import '@polymer/polymer/polymer-legacy.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import { html } from '@polymer/polymer/lib/utils/html-tag.js';
import { PolymerElement } from '@polymer/polymer/polymer-element.js';
class SubMenu extends PolymerElement {
  static get template() {
    return html`
<style include="shared-styles">
                :host {
                    display: block;
                    width: 100%;
                    height: 100%;
    				overflow-y: auto;
                }
            </style>
<div id="dvTabs" style="width:100%;background:#d2d2d2;"></div>
   <vaadin-horizontal-layout style="column-count: 2;display: block;max-height:420px;"> 
    <vaadin-vertical-layout id="butomGroup1">  
     <!--     Button 1  --> 
     <!--   </vaadin-button> --> 
    </vaadin-vertical-layout> 
    <!-- vaadin-vertical-layout id="butomGroup2" --> 
     <!--   <vaadin-button> --> 
     <!--     Button 2  --> 
     <!--   </vaadin-button> --> 
    <!-- /vaadin-vertical-layout --> 
   </vaadin-horizontal-layout> 
`;
  }

  static get is() {
      return 'sub-menu';
  }
  static get properties() {
      return {
          // Declare your properties here. style="width: 100%; height: 100%;margin:100px;">
      };
  }
}
//       customElements.define(TestView.is, TestView);
customElements.define(SubMenu.is, SubMenu);

