import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `sub-submenu`
 *
 * SubSubmenu element.
 *
 * @customElement
 * @polymer
 */
class SubSubmenu extends PolymerElement {

    static get template() {
        return html`
            <style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
   <vaadin-horizontal-layout style="column-count: 2;display: block;max-height:420px;"> 
    <vaadin-vertical-layout id="butomGroup1"></vaadin-vertical-layout> 
   </vaadin-horizontal-layout> 

        `;
    }

    static get is() {
        return 'sub-submenu';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(SubSubmenu.is, SubSubmenu);
