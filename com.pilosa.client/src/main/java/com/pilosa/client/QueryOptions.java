/*
 * Copyright 2017 Pilosa Corp.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its
 * contributors may be used to endorse or promote products derived
 * from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND
 * CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH
 * DAMAGE.
 */

package com.pilosa.client;

import com.pilosa.client.orm.PqlQuery;

/**
 * Contains options to customize {@link PilosaClient#query(PqlQuery, QueryOptions)}.
 * <p>
 * In order to set options, create a {@link Builder} object using {@link QueryOptions#builder()}.
 * <p>
 * <pre>
 *  <code>
 *     QueryOptions options = QueryOptions.builder()
 *         .setColumns(true)
 *         .build();
 *  </code>
 * </pre>
 *
 * @see <a href="https://www.pilosa.com/docs/api-reference/">Pilosa API Reference</a>
 */
public class QueryOptions {
    public static class Builder {
        private Builder() {
        }

        /**
         * Enables returning column data from bitmap queries.
         *
         * @param columns set to <code>true</code> for returning column data
         * @return QueryOptions builder
         */
        public Builder setColumns(boolean columns) {
            this.columns = columns;
            return this;
        }

        /**
         * Creates the QueryOptions object.
         *
         * @return QueryOptions object
         */
        public QueryOptions build() {
            return new QueryOptions(this.columns);
        }

        private boolean columns = false;
    }

    /**
     * Creates a QueryOptions object with the defaults.
     * @return QueryOptions object
     */
    @SuppressWarnings("WeakerAccess")
    public static QueryOptions defaultOptions() {
        return new Builder().build();
    }

    @SuppressWarnings("WeakerAccess")
    public boolean isColumns() {
        return this.columns;
    }

    /**
     * Creates a QueryOptions.Builder object.
     * @return a Builder object
     */
    public static Builder builder() {
        return new Builder();
    }

    private QueryOptions(boolean columns) {
        this.columns = columns;
    }

    private final boolean columns;
}
